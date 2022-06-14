package com.exam.exam1;

public class Calc {
    public int run(String s) {
        s = sripBreker(s);

        String simpleOperation = getSimpleOperation(s);

        if (simpleOperation.equals("number")) {
            return Integer.parseInt(s);
        } else if (simpleOperation.equals("-")) {
            return minus(s);
        } else if (simpleOperation.equals("*")) {
            return matiful(s);
        } else if (simpleOperation.equals("/")) {
            return divide(s);
        } else if (simpleOperation.equals("+")) {
            return Plus(s);
        }

        int spitIndex = -1;
        int bracketCount = 0;
        // 더하기, 빼기로 나눌 수 있는지 체크
        boolean isPlus = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketCount++;
            } else if (s.charAt(i) == ')') {
                bracketCount--;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (bracketCount > 0) {
                    continue;
                }
                spitIndex = i;
                if (s.charAt(i) == '-') {
                    isPlus = false;
                }
                break;
            }
        }
//        String head = s.substring(0, spitIndex).trim();
//        String tail = s.substring(spitIndex + 1, s.length()).trim();
        if (spitIndex != -1) {
            String head = s.substring(0, spitIndex).trim();
            String tail = s.substring(spitIndex + 1).trim();

            if (isPlus) {
                return run(head) + run(tail);
            }
            return run(head) - run(tail);
        }

        spitIndex = -1;
        bracketCount = 0;
        boolean isMulti = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketCount++;
            } else if (s.charAt(i) == ')') {
                bracketCount--;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (bracketCount > 0) {
                    continue;
                }
                spitIndex = i;
                if (s.charAt(i) == '/') {
                    isMulti = false;
                }
                break;
            }
        }

        if (spitIndex != -1) {
            String head = s.substring(0, spitIndex).trim();
            String tail = s.substring(spitIndex + 1).trim();

            if (isMulti) {
                return run(head) * run(tail);
            }
            return run(head) / run(tail);
        }
        return 0;
    }

    private String getSimpleOperation(String s) {
        try {
            Integer.parseInt(s);

            return "number";
        } catch (NumberFormatException e) {

        }
        int nonNumberOperator = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                nonNumberOperator++;
            } else if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if(s.charAt(i + 1) == ' ') {
                    nonNumberOperator++;
                }
            }
        }

        if(nonNumberOperator == 1) {
            if(s.indexOf(" - ") != -1) return "-";
            if(s.indexOf(" + ") != -1) return "+";
            if(s.indexOf(" * ") != -1) return "*";
            if(s.indexOf(" / ") != -1) return "/";
        }
        return "spitInTwo";
    }

    private String sripBreker(String s) {
        s.trim();
        if(s.length() == 0) {
            return s;
        }
        while(s.charAt(0) == '(' && s.charAt(s.length() -1) == ')') {
            s = s.substring(1, s.length() -1);
        }
        return s;
    }

    private int divide(String s) {
        String[] sBits = s.split(" \\/ ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);
        return a / b;
    }

    private int matiful(String s) {
        String[] sBits = s.split(" \\* ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);
        return a * b;
    }

    private int Plus(String s) {
        String[] sBits = s.split(" \\+ ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);
        return a + b;
    }

    private int minus(String s) {
        String[] sBits = s.split(" \\- ");
        int a = Integer.parseInt(sBits[0]);
        int b = Integer.parseInt(sBits[1]);
        return a - b;
    }
}

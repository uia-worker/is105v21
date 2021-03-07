public class Turing {

    public static void main(String[] argv) throws InterruptedException {
       
        // Program (.text)
	String program 	= "0,b,b,R,0\n"
		     	+ "0,*,*,R,1\n"
                        + "1,b,*,R,2\n"
                        + "1,*,*,R,1\n"
                        + "2,b,n,L,3\n"
                        + "2,*,*,R,2\n"
                        + "3,b,b,L,3\n"
                        + "3,*,b,L,4\n"
                        + "4,b,b,-,H\n"
                        + "4,*,*,L,4\n";

        // Data (.data)
        String data = "     * **    ";
        int headPosition = 9;
        int currentStatus = 0;

        String[] dataArray = data.split("(?!^)");

        /*
	for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i]);
        }
        System.out.print("\n");
        */

        // Processing = using Program on Data
        String blank = "\u0020";
        String asterisk = "\u002a";
        // boolean flagStop = false;

	/*
        for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i]);
        }
        System.out.print("\n");
        System.out.println("Head position is " + headPosition); 
        */

	// Compile program
        String lines[] = program.split("\n");
	for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            System.out.println("// " + line);
            // Tokenize
            String status 	= Character.toString(line.charAt(0));
            String read 	= Character.toString(line.charAt(2));
            String write	= Character.toString(line.charAt(4));
            String direction	= Character.toString(line.charAt(6));
	    String nextStatus   = Character.toString(line.charAt(8));
            String headPositionStr = "";
            if (direction.equals("R")) {headPositionStr = "headPosition = headPosition - 1;";}
            if (direction.equals("L")) {headPositionStr = "headPosition = headPosition + 1;";}
            /*
            System.out.print("if (currentStatus == " + status + " && dataArray[headPosition].equals(blank)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
            */
	    // How to know number of status? Explicit? 
	    if (status.equals("0")) {
                if (read.equals("b")) {
                    System.out.print("if (currentStatus == 0 && dataArray[headPosition].equals(blank)) {\n"
            				+ "    dataArray[headPosition] = " + write + "; // or not changing\n"
            				+ "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                } else if (read.equals("*")) {
                    System.out.print("if (currentStatus == 0 && dataArray[headPosition].equals(asterisk)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                }
            } else if (status.equals("1")) {
                if (read.equals("b")) {
		    System.out.print("if (currentStatus == 1 && dataArray[headPosition].equals(blank)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                } else if (read.equals("*")) {
		    System.out.print("if (currentStatus == 1 && dataArray[headPosition].equals(asterisk)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                }
            } else if (status.equals("2")) {
                if (read.equals("b")) {
                    System.out.print("if (currentStatus == 2 && dataArray[headPosition].equals(blank)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                } else if (read.equals("*")) {
                    System.out.print("if (currentStatus == 2 && dataArray[headPosition].equals(asterisk)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                }
            } else if (status.equals("3")) {
                if (read.equals("b")) {
                    System.out.print("if (currentStatus == 3 && dataArray[headPosition].equals(blank)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                } else if (read.equals("*")) {
                    System.out.print("if (currentStatus == 3 && dataArray[headPosition].equals(asterisk)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                }
            } else if (status.equals("4")) {
                if (read.equals("b")) {
                    System.out.print("if (currentStatus == 4 && dataArray[headPosition].equals(blank)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                } else if (read.equals("*")) {
                    System.out.print("if (currentStatus == 4 && dataArray[headPosition].equals(asterisk)) {\n"
                                        + "    dataArray[headPosition] = " + write + "; // or not changing\n"
                                        + "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                }
            } else {
                // an ERROR
                System.out.println("Compilation of Turing program failed. Check sytax...");
            }
            status = nextStatus;
            /*
            System.out.println("// " + "On the tape: [" + String.join("", dataArray) + "]");
            System.out.println("// " + "Current status: " + status);  
            */
        }
	
 
        /**        
        System.out.print("|_|_|_|0|1|1|0|_|_|_|");
        //System.out.print("           ^         ");
        Thread.sleep(2000);
        System.out.print("\r"); 
        System.out.print("|_|_|_|_|0|1|1|0|_|_|");
        //System.out.print("           ^         ");
        Thread.sleep(2000);
        System.out.print("\r");
        System.out.print("|_|_|_|_|_|0|1|1|0|_|");
        //System.out.println("           ^         ");
        System.out.print("\n");
        */
    }

}

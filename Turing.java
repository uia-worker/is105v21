public class Turing {

    public static void main(String[] argv) throws InterruptedException {
       
        // Program (.text)
	String program 	= "0,b,b,R,1\n"
		     	+ "0,*,*,R,1\n";

        // Data (.data)
        String data = "     * **    ";
        int headPosition = 9;
        int currentStatus = 0;

        String[] dataArray = data.split("(?!^)");
        for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i]);
        }
        System.out.print("\n");
        
        // Processing = using Program on Data
        String blank = "\u0020";
        String asterisk = "\u002a";
        boolean flagStop = false;

        if (currentStatus == 0 && dataArray[headPosition].equals(blank)) {
            dataArray[headPosition] = blank; // or not changing
            headPosition = headPosition - 1; // we are breaking with the model
        } 
        if (currentStatus == 0 && dataArray[headPosition].equals(asterisk)) {
            dataArray[headPosition] = asterisk; // or not changing
            headPosition = headPosition - 1; // we are breaking with the model
        } 

        for (int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i]);
        }
        System.out.print("\n");
        System.out.println("Head position is " + headPosition); 

	// Compile program
        String lines[] = program.split("\n");
	for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            System.out.println(line);
            // Tokenize
            String status 	= Character.toString(line.charAt(0));
            String read 	= Character.toString(line.charAt(2));
            String write	= Character.toString(line.charAt(4));
            String direction	= Character.toString(line.charAt(6));
	    String nextStatus   = Character.toString(line.charAt(8));
            String headPositionStr = "";
            
            // How to know number of status? Explicit? 
	    if (status.equals("0")) {
                if (read.equals("b")) {
                    if (direction.equals("R")) {headPositionStr = "headPosition = headPosition - 1;";}
                    if (direction.equals("L")) {headPositionStr = "headPosition = headPosition + 1;";}
                    System.out.print("if (currentStatus == 0 && dataArray[headPosition].equals(blank)) {\n"
            				+ "    dataArray[headPosition] = " + write + "; // or not changing\n"
            				+ "    " + headPositionStr + " // we are breaking with the model\n"
                                        + "}\n");
                } else if (read.equals("*")) {
                    
                }
            } else if (status.equals("1")) {
                // status = 1
            } else if (status.equals("2")) {
                // status = 2
            } else {
                // an ERROR
            }
            status = nextStatus;
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

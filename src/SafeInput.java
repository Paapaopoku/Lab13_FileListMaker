import java.util.Scanner;

public class SafeInput
{


    public static Scanner tester = new Scanner(System.in);

    public static void main(String[] args)
    {
        String firstName = "";
        String lastName = "";
        int age = 0;

        /*
        firstName = getNonZeroLenString(tester, "Enter your name");
        System.out.println("Name is : " + firstName);

        lastName = SafeInput.getNonZeroLenString(tester, "Enter your last name");
        System.out.println("last name is : " + lastName);
        */
        age = getInt(tester, "Enter your age");
        System.out.println("Age is " + age);
    }
    // All of the methods go here
    // as we test them, we will copy them into SafeInput

    /**
     * Returns a String from the user that has at least one character
     * Blocks and repeats until the input is correct
     * @param pipe Scanner to use to read the string
     * @param prompt String that tells the user what to input
     * @return String obtained from the user that is of at least length 1
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        boolean done = false;
        String response = "";
        do {
            // display the prompt
            System.out.print(prompt + ": ");
            // get the input
            response = pipe.nextLine();
            // check if valid and end loop if it is
            if(response.length() > 0)
            {
                done = true;
            }
            else
            {
                System.out.println("\nYou must enter at least one character!\n");
            }

        }while(!done);

        return response;
    }

    /**
     * Get an int from the user with no limit on its range
     * @param pipe Scanner to user on what to enter
     * @param prompt msg for user on what to enter
     * @return returns the val
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        boolean done = false;
        String trash = "";
        int val = 0;
        do {
            // display the prompt
            System.out.print(prompt + ": ");
            // get the input
            if(pipe.hasNextInt())
            {
                val = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else // Don't have an Int
            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid int");
            }


        }while(!done);

        return val;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        boolean done = false;
        String trash = "";
        double val = 0;
        do {
            // display the prompt
            System.out.print(prompt + ": ");
            // get the input
            if(pipe.hasNextDouble())
            {
                val = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else // Don't have an Int
            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid double");
            }


        }while(!done);

        return val;
    }
    /**
     * Get an int from the user within the required range
     * @param pipe Scanner to user on what to enter
     * @param prompt msg for user on what to enter
     * @param low this is inclusive low boundary of the range
     * @param high this is inclusive high boundary of the range
     * @return returns the val
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        boolean done = false;
        String trash = "";
        int val = 0;
        do {
            // display the prompt
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            // get the input
            if(pipe.hasNextInt())
            {
                val = pipe.nextInt();
                pipe.nextLine();

                if(val >= low && val <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println( val + " is not in the range [" + low + " - " + high + "] ");
                }
            }
            else // Don't have an Int
            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid int");
            }


        }while(!done);

        return val;
    }

    /**
     * Get a double from the user within a specific range
     * @param pipe Scanner to user on what to enter
     * @param prompt msg for user on what to enter
     * @param low low boundary for inclusive range
     * @param high high boundary for inclusive range
     * @return returns the val
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        boolean done = false;
        String trash = "";
        double val = 0;
        do {
            // display the prompt
            System.out.print(prompt + "[" + low + " - " + high + "]: ");
            // get the input
            if(pipe.hasNextDouble())
            {
                val = pipe.nextDouble();
                pipe.nextLine();

                if(val >= low && val <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println( val + " is not in the range [" + low + " - " + high + "] ");
                }
            }
            else // Don't have an Int
            {
                trash = pipe.nextLine();
                System.out.println("\nYou entered: " + trash + " you must enter a valid double!");
            }


        }while(!done);

        return val;
    }
    /**
     * gets a Y or N from the user and returns true or false accordingly
     * @param pipe scanner to use for the input
     * @param prompt msg to tell user what to input Y or N
     * @return retValue
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String YNResponse = "";
        boolean retValue = false;

        System.out.print(prompt + "[Y/N]: ");
        YNResponse = pipe.nextLine();
        while (YNResponse.equalsIgnoreCase("y") && YNResponse.equalsIgnoreCase("n"))
        {
            System.out.println("\nYou must enter [YyNn]: not " + YNResponse);
            System.out.print(prompt + "[Y/N]: ");
            YNResponse = pipe.nextLine();
        }


        if(YNResponse.equalsIgnoreCase("y"))
        {
            retValue = true;
        }


        return retValue;
    }

    /**
     * returns true if the user entered a String that matches a supplied REgEx pattern
     * @param pipe Scanner to use for input
     * @param prompt msg top user for what to enter usually the RegEx String
     * @param regEx A string that represents a Regex pattern
     * @return
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;
        String response = "";
        do {
            // display the prompt
            System.out.print(prompt + " " + regEx + ": ");
            // get the input
            response = pipe.nextLine();
            // check if valid and end loop if it is
            if(response.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("\nYou must match the RegEx pattern!\n");
            }

        }while(!done);

        return response;
    }
    public static void prettyHeader(String msg)
    {
        //Top
        for (int x = 0; x <= 60; x++)
        {
            System.out.print("*");
        }
        //Middle
        System.out.println();
        int msgLength = msg.length();
        int totalLength = 54 - msgLength;
        int spaceLength = totalLength / 2;
        System.out.print("***");
        for (int x = 0; x <= spaceLength; x++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int x = 0; x <= spaceLength; x++)
        {
            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();
        //Bottom
        for (int x = 0; x <= 60; x++)
        {
            System.out.print("*");
        }

    }

}
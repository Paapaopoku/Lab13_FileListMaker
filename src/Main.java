import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.nio.file.Path;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Main
{
    private static ArrayList<String> list = new ArrayList<>();
    private static boolean needsToBeSaved = false;

    public static void main(String[] args)
    {

        final String menu = "A - Add D - Delete V - View O - Open S - Save C - Clear Q - Quit";
        boolean done = false;
        String cmd = "";
        boolean needsToBeSaved = false;
        String fileName = "";
        Scanner in = new Scanner(System.in);

        do {
            displayList();


            cmd = SafeInput.getRegExString(in, menu, "[AaDdVvOoSsCcQq]");
            cmd = cmd.toUpperCase();

            switch (cmd)
            {
                case "A":
                    Add();
                    needsToBeSaved = true;
                    break;
                case "D":
                    Delete();
                    needsToBeSaved = true;
                    break;
                case "V":
                    break;
                case "O":
                    Open();
                    break;
                case "S":
                    Save();
                    needsToBeSaved = true;
                    break;
                case "C":
                    Clear();
                    needsToBeSaved = true;
                    break;
                case "Q":
                    if(SafeInput.getYNConfirm(in, "Are you sure you want to quit?"))
                    {
                        done = true;
                    }
                    break;
            }
            System.out.println("cmd is " + cmd);


        }
        while (!done) ;
    }

    private static void displayList()
    {
        System.out.println("---------------------------------------------");
        if(list.size() != 0)
        {

            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("%d. %s\n", i+1, list.get(i));
            }

        }
        else
            System.out.println(" ---      Nothing in the list      ---");
        System.out.println("---------------------------------------------");
    }

    private static void Add()
    {
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item you want to add");
        list.add(item);
    }

    private static void Delete()
    {
        Scanner in = new Scanner(System.in);
        int dItem = SafeInput.getRangedInt(in, "What item number do you want to delete?: ", 1, list.size());
        list.remove(dItem - 1);
    }

    private static void Clear()
    {
        list.clear();
    }

    private static void Open()
    {


        if (needsToBeSaved) {
            System.out.println("You have unsaved changes. Please save your list before loading a new one.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename to open: ");
        String fileName = scanner.nextLine();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".txt"))) {
            list = (ArrayList<String>) ois.readObject();
            System.out.println("List loaded successfully.");
            needsToBeSaved = false;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading the list: " + e.getMessage());
        }

    }

    public static void Save()
    {
        String fileName = "";


        PrintWriter outFile;
        Path file = new File(System.getProperty("user.dir")).toPath();
        if (fileName.equals(""))
        {
            file = file.resolve("src\\list.txt");
        }else
        {
            file = file.resolve(fileName);
        }

        try
        {
            outFile = new PrintWriter(file.toString());
            for (int i = 0; i < list.size(); i++) {
                outFile.println(list.get(i));
            }
            outFile.close();
            System.out.printf("File \"%s\" saved!\n", file.getFileName());
        } catch (IOException e) {
            System.out.println("IOException Error");
        }
    }
}
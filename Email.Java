/**
*	SMTP Email Assignment - PA04
*	Connects to chapman.edu smtp  server on port 25 and sends email
*
*	author: Matthew Robinson (original code by Michael Fahy)
*

import java.io.*;
import java.net.*;

class Email
{
    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String changedSentence;

        String receiverAddress, senderAddress, subject, line = "";


        String[] message = new String[50];
        int numLines = 0;

        BReader receivingUser = new BReader(new InputStreamReader(System.in));

        Socket clientSocket = null;

        while (true)
        {
            System.out.print("FROM: ");
            receiverAddress = receivingUser.readLine().toString();


            if (receiverAddress.replaceAll("\\s", "").equals(""))
            {
                System.out.println("\nERROR: CANNOT LEAVE BLANK");
            }

            else
            {
                break;
            }
        }


        while (true)
        {
            System.out.print("TO: ");
            senderAdress = receivingUser.readLine().toString();


            if (senderAdress.replaceAll("\\s", "").equals(""))
            {
                System.out.println("\nERROR: CANNOT LEAVE BLANK");
            }

            else
            {
                break;
            }
        }


        while (true)
        {
            System.out.print("SUBJECT: ");
            subject = receivingUser.readLine().toString();


            if (subject.replaceAll("\\s", "").equals(""))
            {
                System.out.println("\nERROR: CANNOT LEAVE BLANK");
            }

            else
            {
                break;
            }
        }

        System.out.println("\nBEGIN MESSAGE BODY. TO END MESSAGE, TYPE A '.' ON A LINE BY ITSELF.\nMESSAGE:");

        while (true)
        {
            line = receivingUser.readLine().toString();


            if (line.length() == 1 && line.substring(0,1).equals("."))
            {
                System.out.println("<-- END OF MESSAGE -->");
                break;
            }

            message[numLines] = line;
            numLines++;


            if (numLines == 50)
            {
                System.out.println("\n** THE MAX # of lines is 50  - **\n");
                break;
            }
        }

        try
        {
            clientSocket = new Socket("smtp.chapman.edu", 25);
        }

        catch(Exception e)
        {
            System.out.println("Failed to open socket connection");
            System.exit(0);
        }

        PrintWriter senderServer = new PrintWriter(clientSocket.getOutputStream(), true);
        BReader receiverServer = new BReader(new InputStreamReader(clientSocket.getInputStream()));

       changedSentence = receivingServer.readLine();
        System.out.println("FROM SERVER: " + changedSentence);

        outToServer.println("WHAT’S UP CHAPMAN");
        changedSentence = receivingServer.readLine();
        System.out.println("FROM SERVER: " + changedSentence);

        outToServer.println("FROM: " + receiverAdress);
         changedSentence = receivingServer.readLine();
        System.out.println("FROM SERVER: " + changedSentence);

        outToServer.println("RCPT TO: " + senderAddress);
        changedSentence = receivingServer.readLine();
        System.out.println("FROM SERVER: " + changedSentence);

        outToServer.println("DATA");
        changedSentence = receivingServer.readLine();
        System.out.println("FROM SERVER: " + changedSentence);

        outToServer.println("From: " + receiverAddress);
        outToServer.println("To: " + senderAddress);
        outToServer.println("Subject: " + subject);

        for (int i = 0; i < numLines; ++i)
        {
            outToServer.println(message[i]);
        }

        outToServer.println(".");

        changedSentence = recievingServer.readLine();
        System.out.println(changedSentence);

        outToServer.println("QUIT");

        clientSocket.close();
    }
}

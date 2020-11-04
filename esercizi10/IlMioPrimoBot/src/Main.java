import java.io.File;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import botBase.BotBase;
import botListaDellaSpesa.BotListaDellaSpesa;
import botRandomMedia.BotRandomMedia;

import com.botticelli.bot.Bot;
import com.botticelli.messagereceiver.MessageReceiver;

public class Main {

    public static String filePath;

    public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, UnknownHostException, SocketException
    {
        filePath = new File("").getAbsolutePath() + System.getProperty("file.separator");
        File tokenFile = new File(filePath + "token.txt");
        String token = "";
        try (Scanner s = new Scanner(tokenFile))
        {
            while (s.hasNext())
            {
                token = s.nextLine();
            }
        }

        //Bot bot = new PrimoBot(token);
        //Bot bot = new BotBase(token);
        //Bot bot = new BotRandomMedia(token);
        Bot bot = new BotListaDellaSpesa(token);

        MessageReceiver mr = new MessageReceiver(bot, 500, 1);
        mr.ignoreEditedMessages();
        mr.start();

    }
}

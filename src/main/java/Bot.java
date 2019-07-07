import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {

    Message message;
//    Scanner scanner=new Scanner(System.in);
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            message=update.getMessage();
            SendMessage sendMessage=new SendMessage();
            sendMessage.setChatId(message.getChatId());
            if(message.getText().equals("/start")){
                sendMessage.setText("Assalomu alaykum "+message.getFrom().getFirstName()+".\nSiz bilan yaqinroq tanishsak bo'ladimi?");
            }
            else if(message.getText().equals("/help")){
                sendMessage.setText("Avtor by:Anvar Quvandiqov");
            }
            else{
                sendMessage.setText("Palakat");
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

  /*  public synchronized void sendMsg(Message message) {
//        System.out.println(message.getText());
//        System.out.println(message.getSticker());
//        System.out.println(message.getChatId());

        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(message.getChatId());
        if(message.getText().equals("/start")){
            sendMessage.setText("Assalomu alaykum "+message.getFrom().getFirstName()+".\nSiz bilan yaqinroq tanishsak bo'ladimi?");
        }
        else if(message.getText().equals("/help")){
            sendMessage.setText("Avtor by:Anvar Quvandiqov");
        }
        else {
            sendMessage.setText("hd");
        }
        if(message.getChatId()!=165527805){
            try {
                execute(new SendMessage("165527805",
                        "\nUserName:"+message.getFrom().getUserName()+
                                "\nFromName:"+message.getFrom().getFirstName()+
                                " "+message.getFrom().getLastName()+
                                "ChatId:"+message.getChatId()+
                                "\nMessageId:"+message.getMessageId()+
                                "\nText:\n"+message.getText()));

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }



//        sendMessage.setReplyToMessageId(message.getMessageId());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
*/


    @Override
    public String getBotUsername() {
        return BotConfig.USER;
    }

    @Override
    public String getBotToken() {
        return BotConfig.TOKEN;
    }
}

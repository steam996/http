package ru.netology;

public class Response {
//    id - уникальный идентификатор записи
//    text - сообщение
//    type - тип животного
//    user - имя пользователя
//    upvotes - голоса
    private String id;
    private String text;
    private String type;
    private String user;
    private String  upvotes;
    public Response(){

    }

    public Response(String id, String text, String type, String user, String upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "id='" + id + '\''+ ","  + "\n" +
                " text='" + text + '\''+ ","  + "\n" +
                " type='" + type  + '\''+ ","  + "\n" +
                " user='" + user  + '\''+ ","  + "\n" +
                " upvotes='" + upvotes  + '\'' + "." + "\n" +
                '}' + "\n";
    }
}

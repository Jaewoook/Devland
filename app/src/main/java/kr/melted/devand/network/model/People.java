package kr.melted.devand.network.model;

/**
 * Created by Envy on 2015-12-19.
 */
public class People {

    public People(String name, String position, String comment, String event_name) {
        this.name = name;
        this.position = position;
        this.event_name = event_name;
    }

    public String name;
    public String _id;
    public String position;
    public String comment;
    public String event_name;
}

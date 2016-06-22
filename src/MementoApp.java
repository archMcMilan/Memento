/**
 * Created by Artem on 22.06.16.
 */
public class MementoApp {
    public static void main(String[] args) {
        Game game=new Game();
        game.set("LVL 1",30_000);
        System.out.println(game);

        File file=new File();
        file.setSave(game.save());

        game.set("LVL 2",55_000);
        System.out.println(game);

        game.load(file.getSave());
        System.out.println(game);
    }
}

//Originator
class Game{
    private String level;
    private int ms;
    public void set(String level,int ms){
        this.level=level;
        this.ms=ms;
    }
    public void load(Save save){
        set(save.getLevel(),save.getMs());
    }
    public Save save(){
        return new Save(level,ms);
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
}

//Memento
class Save{
    private final String level;
    private final int ms;

    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }
    public int getMs() {
        return ms;
    }
}

//Caretaker
class File{
    Save save;

    public Save getSave() {
        return save;
    }
    public void setSave(Save save) {
        this.save = save;
    }
}
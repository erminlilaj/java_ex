import java.util.Date;
public class Monkey extends Animal {

    private boolean tail;

    public Monkey(int id, String name, Date birthdate, boolean tail) {
        super(id, name, birthdate);
        this.tail = tail;
    }

    public boolean hasTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monkey monkey = (Monkey) o;
        return id == monkey.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

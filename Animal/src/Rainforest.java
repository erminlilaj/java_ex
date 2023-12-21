

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
public class Rainforest {

    private Monkey[] monkeys;
    private int index;

    public Rainforest() {
        this(5);
    }

    public Rainforest(int size) {
        this.monkeys = new Monkey[size];
        this.index = 0;
    }

    public boolean addMonkey(Monkey monkey) {
        if (!monkey.hasTail()) {
            return false;
        }

        if (index == monkeys.length) {
            // Expand the array if it's full
            Monkey[] newMonkeys = new Monkey[monkeys.length * 2];
            System.arraycopy(monkeys, 0, newMonkeys, 0, monkeys.length);
            this.monkeys = newMonkeys;
        }

        monkeys[index++] = monkey;
        return true;
    }

    public Monkey searchMonkey(String name) {
        for (Monkey monkey : monkeys) {
            if (monkey != null && monkey.getName().equals(name)) {
                return monkey;
            }
        }
        return null;
    }

    public Monkey[] sorted() {
        Arrays.sort(monkeys, Comparator.comparing(Animal::getBirthdate));
        return monkeys;
    }

    public void toFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Monkey monkey : monkeys) {
                if (monkey != null) {
                    writer.write(monkey.getId() + ";" + monkey.getName() + ";" + monkey.getBirthdate() + ";" + monkey.hasTail() + "\n");
                }
            }
        }
    }

    public void fromFile(String filePath) throws IOException, CorruptedFileException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 4) {
                    throw new CorruptedFileException("Invalid file format");
                }

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                Date birthdate = new Date(parts[2]);
                boolean tail = Boolean.parseBoolean(parts[3]);

                Monkey monkey = new Monkey(id, name, birthdate, tail);
                addMonkey(monkey);
            }
        }
    }
}

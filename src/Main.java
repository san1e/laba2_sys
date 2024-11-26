import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Перевіряємо, чи є прапорець "--ignore-case" серед аргументів
        boolean ignoreCase = Arrays.asList(args).contains("--ignore-case");
        String filterWord = null;

        // Обробка аргументів командного рядка
        List<String> inputArgs = new ArrayList<>(Arrays.asList(args));
        inputArgs.remove("--ignore-case"); // Видаляємо "--ignore-case", якщо він є

        // Знаходимо та отримуємо слово для фільтрації після аргументу "-filter"
        int filterIndex = inputArgs.indexOf("-filter");
        if (filterIndex != -1 && filterIndex + 1 < inputArgs.size()) {
            filterWord = inputArgs.get(filterIndex + 1); // Отримуємо слово для фільтрації
        }

        // Читання вводу через BufferedReader з System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Виведення через PrintWriter в System.out
        PrintWriter writer = new PrintWriter(System.out);

        try {
            String line;
            // Читання кожного рядка з вводу
            while ((line = reader.readLine()) != null) {
                // Перетворюємо рядок та слово для фільтрації в нижній регістр, якщо прапорець ignoreCase встановлений
                String targetLine = ignoreCase ? line.toLowerCase() : line;
                String targetFilterWord = ignoreCase && filterWord != null ? filterWord.toLowerCase() : filterWord;

                // Якщо ключове слово не задано або рядок містить це слово, виводимо його
                if (filterWord == null || targetLine.contains(targetFilterWord)) {
                    writer.println(line); // Виводимо рядок на екран
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Виводимо помилку, якщо виникла проблема з читанням вводу
        } finally {
            writer.flush(); // Переконуємось, що весь вивід записано
        }
    }
}

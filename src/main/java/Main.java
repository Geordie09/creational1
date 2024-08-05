public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Светлана")
                .setSurname("Волкова")
                .setAge(31)
                .setAddress("Самара")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Михаил")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
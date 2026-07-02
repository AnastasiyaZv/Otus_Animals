package input.validators;

public class PredicatesWhereInput extends AbsInput{

    public String getPredicatesWhere(){
        String predicatesInput = null;
        do {
            System.out.println("Введите условие, например type='CAT': ");
            predicatesInput = scanner.nextLine();
            if (predicatesInput.length() == 0){
                System.out.println("Условие не может быть пyстым");
            }
        } while (predicatesInput.length() == 0);
        return predicatesInput;
    }
}

package input.validators;

public class PredicatesSetInput extends AbsInput{

    public String getPredicatesSet(){
        String predicatesInput = null;
        do {
            System.out.println("Введите поле и значение для изменения, например type='CAT': ");
            predicatesInput = scanner.next();
            if (predicatesInput.length() == 0){
                System.out.println("Условие для изменения не может быть пyстым");
            }
        } while (predicatesInput.length() == 0);
        return predicatesInput;
    }

}

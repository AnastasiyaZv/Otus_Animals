package input.validators;

import input.messageForUser.MessagePredicates;

public class PredicatesInput extends AbsInput{

    private final MessagePredicates messagePredicates;

    public PredicatesInput(MessagePredicates messagePredicates){
        this.messagePredicates = messagePredicates;
    }

    public String getPredicates(){
        String predicates = "";
        do {
            System.out.println(messagePredicates.getInfoMessage());
            predicates = scanner.nextLine();

            if (predicates.length() == 0){
                System.out.println(messagePredicates.getMessageIsNull());
            }
        } while (predicates.length() == 0);
        return predicates;
    }
}

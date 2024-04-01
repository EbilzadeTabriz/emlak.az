package TK.example.emlak.az.exception;

import java.util.function.Supplier;

public class NotFoundByMertebe extends RuntimeException{
    public NotFoundByMertebe(String message) {
        super(message);
    }
}

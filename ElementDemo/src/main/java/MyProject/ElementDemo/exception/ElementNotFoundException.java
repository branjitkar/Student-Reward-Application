package MyProject.ElementDemo.exception;

    public class ElementNotFoundException extends RuntimeException{
        private String message;

        public ElementNotFoundException(String message) {
            super(message);
            this.message = message;
        }

    }

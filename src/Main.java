public class Main {
    public static void main(String[] args) {
        // TODO: подставлять номер карты нужно сюда между двойными кавычками, без пробелов
        checkValidation("5351719427810741");
        checkValidation("");
        checkValidation("dddddddddddddddd");
        checkValidation("5351 7194 2781 0741");
        checkValidation("62600094752489245"); // China Unionpay
        checkValidation("4767239209947232"); // Visa
        checkValidation("5119376578140304"); // Mastercard
        checkValidation("5038386039801541"); // Maestro
        checkValidation("340761308830351"); // American Express (AMEX):
        checkValidation("5427417330264235"); // Diners Club - North America:
        checkValidation("36446937699166"); // Diners Club - International:
        checkValidation("4929334228979056298"); // Visa
        checkValidation("2202500798592793"); // Mir
        checkValidation("2200613762270612"); // Mir
    }

    public static void checkValidation(String number) {
        System.out.println(String.format("\""+number + "\" Result is %s", isValidCardNumber(number) ? "OK" : "FAIL"));
    }

    public static boolean isValidCardNumber(String number) {
        if (number == null) {
            return false;
        }

        if (number.length() != 16) {
            return false;
        }

        long result = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit;
            try {
                digit = Integer.parseInt(number.charAt(i) + "");
            } catch (NumberFormatException e) {
                return false;
            }

            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            result += digit;
        }

        return (result != 0) && (result % 10 == 0);
    }
}

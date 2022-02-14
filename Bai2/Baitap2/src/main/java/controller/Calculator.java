package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @GetMapping("/")
    public String loadIndex() {
        return "index";
    }


    @GetMapping(path = "/calculator")
    public String select(
            @RequestParam("number1") double number1,
            @RequestParam("opera") String opera,
            @RequestParam("number2") double number2,
            Model model
    ) {
        double select = calculator(number1, number2, opera);
        model.addAttribute("result", select);
        return "index";
    }

    private double calculator(double number1, double number2, String opera) {
        switch (opera) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                } else {
                    return number1 / number2;
                }
            case "*":
                return number1 * number2;
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
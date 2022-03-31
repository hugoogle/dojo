import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class login {

    @Test
    public void LoginValido() {

        //dado a url seu barriga
        open("https://seubarriga.wcaquino.me/login");

        //quando informar email
        $(By.id("email")).setValue("hugo.ferreira@bluesoft.com.br");

        //quando informar senha
        $(By.id("senha")).setValue("8437");

        //quando clicar no botao entrar
        $(byClassName("btn-primary")).click();

        //entao é exibido a mensagem Bem vindo!
        Assertions.assertEquals("Bem vindo, hugo!", $(".alert-success").getText());

    }

    @Test
    public void loginInvalido() {

        open("https://seubarriga.wcaquino.me/login");
        // Mapeando elemento com cssSelector
        // Atributo ID incluimos na frente do nome o caracter #
        // Atributo CLASS incluimos na frente do nome o caracter .

        $("#email").setValue("ferreira@bluesoft.com.br");
        $("#senha").setValue("8437");
        $(".btn-primary").click();

        Assertions.assertEquals("Problemas com o login do usuário", $(".alert-danger").getText());

    }

    @Test
    public void loginSelenideElement() {

        open("https://seubarriga.wcaquino.me/login");

        SelenideElement inputEmail = $("#email");
        SelenideElement inputSenha = $("#senha");
        SelenideElement btnEntrar  = $(".btn-primary");
        SelenideElement mensagem   = $(".alert-success");

        inputEmail.setValue("hugo.ferreira@bluesoft.com.br");
        inputSenha.setValue("8437");
        btnEntrar.click();

        Assertions.assertEquals("Bem vindo, hugo!", mensagem.getText());


    }


}

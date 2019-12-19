package ru.netology.aqa21;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

class FormTest {
    @Test
    void shouldSubmitForm(){
        open("http://localhost:9999/");

        $(By.name("name")).setValue("Иван Разуваев");
        $(By.cssSelector("[type = tel]")).setValue("+79995671111");
        SelenideElement agriment = $("[data-test-id=agreement]");
        agriment.click();
        $(By.tagName("button")).submit();
        $("[data-test-id=\"order-success\"]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
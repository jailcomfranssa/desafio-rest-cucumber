package StepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class DesafioSteps {

    @Dado("passa o paramentro ola")
    public void passa_o_paramentro_ola() {
        System.out.println("endpoint ola");
    }

    @Quando("execultado recebe o valor ok")
    public void execultado_recebe_o_valor() {
       given()
       .when()
            .get("http://restapi.wcaquino.me/ola")
       .then()
            .statusCode(200);
    }

    @Entao("retorna o valor Ola Mundo!")
    public void retorna_o_valor_Ola_Mundo() {
        given()
        .when()
            .get("http://restapi.wcaquino.me/ola")
        .then()
            .body(Matchers.is("Ola Mundo!"));

    }


    @Dado("o valor users1")
    public void o_valor_users1() {
        System.out.println("endpoint users1");
    }

    @Quando("execultado recebe sucesso")
    public void execultado_recebe_sucesso() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/1")
        .then()
        .statusCode(200);

    }

    @Entao("retorna nome e idade do usuario")
    public void retorna_nome_e_idade_do_usuario() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/1")
        .then()
            .body("name",Matchers.is("João da Silva"))
            .body("age",Matchers.is(30));

    }


    @Dado("o valor users2")
    public void o_valor_users2() {
        System.out.println("endpoint users2");
    }

    @Quando("execultado com sucesso recebe usuario2")
    public void execultado_com_sucesso_recebe_usuario2() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/2")
        .then()
            .statusCode(200);
    }

    @Entao("retorna nome, idade, endereco e salary")
    public void retorna_nome_idade_endereco_e_salary() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/2")
        .then()
            .body("name",Matchers.is("Maria Joaquina"))
            .body("age",Matchers.is(25))
            .body("endereco.rua",Matchers.is("Rua dos bobos"))
            .body("endereco.numero",Matchers.is(0))
            .body("salary",Matchers.is(2500));
    }

    @Dado("o valor users3")
    public void o_valor_users3() {
        System.out.println("endpoint users3");
    }

    @Quando("execultado com sucesso recebe usuario3")
    public void execultado_com_sucesso_recebe_usuario3() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/3")
        .then()
            .statusCode(200);
    }

    @Entao("retorna nome, idade e seus filhos")
    public void retorna_nome_idade_e_seus_filhos() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/3")
        .then()
            .body("name",Matchers.is("Ana Júlia"))
            .body("age",Matchers.is(20))
            .body("filhos[0].name",Matchers.is("Zezinho"))
            .body("filhos[1].name",Matchers.is("Luizinho"))
            .body("filhos.name",Matchers.contains("Zezinho","Luizinho"))

                ;
    }

    @Dado("o valor inixistente")
    public void o_valor_inixistente() {
        System.out.println("endpoint users4");
    }

    @Quando("execultado recebe o valor Not Found")
    public void execultado_recebe_o_valor_Not_Found() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/4")
        .then()
            .statusCode(404);
    }

    @Entao("retorna Usuário inexistente")
    public void retorna_Usuário_inexistente() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users/4")
        .then()
            .body("error",Matchers.is("Usuário inexistente"));
    }

    @Dado("o valor users")
    public void o_valor_users() {
        System.out.println("endpoint users");
    }

    @Quando("execultado recebe o valor de todos usuarios")
    public void execultado_recebe_o_valor_de_todos_usuarios() {
        given()
        .when()
            .get("http://restapi.wcaquino.me/users")
        .then()
           .statusCode(200);
    }

    @Entao("retorna todos os usuarios com suas reséctivas informação")
    public void retorna_todos_os_usuarios_com_suas_reséctivas_informação() {
        given()
        .when()
           .get("http://restapi.wcaquino.me/users")
        .then()
            .body("name",Matchers.contains( "João da Silva", "Maria Joaquina", "Ana Júlia"))
            .body("salary",Matchers.contains(1234.5678f, 2500, null))
                //Usuario-01
            .body("id[0]",Matchers.is(1))
            .body("name[0]",Matchers.is("João da Silva"))
            .body("age[0]",Matchers.is(30))
            .body("salary[0]",Matchers.is(1234.5678f))
                //Usuario-02
            .body("id[1]",Matchers.is(2))
            .body("name[1]",Matchers.is("Maria Joaquina"))
            .body("age[1]",Matchers.is(25))
            .body("salary[1]",Matchers.is(2500))
            .body("endereco[1].rua",Matchers.is("Rua dos bobos"))
            .body("endereco[1].numero",Matchers.is(0))

                //Usuario-03
            .body("id[2]",Matchers.is(3))
            .body("name[2]",Matchers.is("Ana Júlia"))
            .body("age[2]",Matchers.is(20))
            .body("filhos[2].name[0]",Matchers.is("Zezinho"))
            .body("filhos[2].name[1]",Matchers.is("Luizinho"))
            ;

    }

}

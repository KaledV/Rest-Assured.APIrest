package br.ce.kvferreira.rest.tests.refac.suite;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.kvferreira.rest.core.BaseTest;
import br.ce.kvferreira.rest.tests.refac.AuthTest;
import br.ce.kvferreira.rest.tests.refac.ContasTest;
import br.ce.kvferreira.rest.tests.refac.MovimentacaoTest;
import br.ce.kvferreira.rest.tests.refac.SaldoTest;
import io.restassured.RestAssured;

@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	ContasTest.class,
	MovimentacaoTest.class,
	SaldoTest.class,
	AuthTest.class
})
public class Suite extends BaseTest {
	
	@BeforeClass
	public static void login() {
		Map<String, String> login = new HashMap<> ();
		login.put("email", "fakemail@gmail.com.br");
		login.put("senha", "Kaled@123");
		
		String TOKEN = given()
		   .body(login)
		.when()
		  .post("/signin")
		.then()
		  .statusCode(200)
		  .extract().path("token");
		
		RestAssured.requestSpecification.header("Authorization", "JWT " + TOKEN);
		
		RestAssured.get("/reset").then().statusCode(200);
	}

}

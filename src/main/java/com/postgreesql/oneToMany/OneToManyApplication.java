package com.postgreesql.oneToMany;

import com.postgreesql.oneToMany.models.Banco;
import com.postgreesql.oneToMany.models.Cuenta;
import com.postgreesql.oneToMany.repos.BancoRepository;
import com.postgreesql.oneToMany.repos.CuentaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.text.AbstractDocument;

@SpringBootApplication
public class OneToManyApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OneToManyApplication.class, args);

		BancoRepository bancoRepository = context.getBean(BancoRepository.class);
		CuentaRepository cuentaRepository = context.getBean(CuentaRepository.class);

		Banco banco1 = new Banco(null, "Santander");
		Banco banco2 = new Banco(null, "Itau");

		bancoRepository.save(banco1);
		bancoRepository.save(banco2);

		Cuenta cuenta11 = new Cuenta(null, "Daniel JA", banco1);
		Cuenta cuenta12 = new Cuenta(null, "Pedro JA", banco1);
		Cuenta cuenta21 = new Cuenta(null, "Juan JA", banco2);
		Cuenta cuenta22 = new Cuenta(null, "Sara JA", banco2);

		cuentaRepository.save(cuenta11);
		cuentaRepository.save(cuenta12);
		cuentaRepository.save(cuenta21);
		cuentaRepository.save(cuenta22);

		System.out.println("Cuenta11: " + cuenta11.toString());
		System.out.println("Cuenta12: " + cuenta12.toString());
		System.out.println("Cuenta21: " + cuenta21.toString());
		System.out.println("Cuenta22: " + cuenta22.toString());
	}

}

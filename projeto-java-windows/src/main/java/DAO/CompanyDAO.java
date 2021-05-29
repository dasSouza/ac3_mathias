package DAO;;

import ConectionBDA.Conection;
import jdbc.Conexao;
import Empresa.CompanyData;
import org.springframework.jdbc.core.JdbcTemplate;
import ConectionBDA.Conection;
import jdbc.Conexao;
import Empresa.CompanyData;
import org.springframework.jdbc.core.JdbcTemplate;
import ConectionBDA.Conection;
import jdbc.Conexao;
import Empresa.CompanyData;
import org.springframework.jdbc.core.JdbcTemplate;
import ConectionBDA.Conection;
import jdbc.Conexao;
import Empresa.CompanyData;
import org.springframework.jdbc.core.JdbcTemplate;


public class CompanyDAO {

    public void insertIntoCompany() {
//        Conection conection = new Conection();
        Conexao con = new Conexao();
        CompanyData companyData = new CompanyData();
        JdbcTemplate template = new JdbcTemplate(con.getBanco());

        String insertEmpresaValues = "INSERT INTO tb_empresa(kc_nome_comp, kc_cep_comp," +
                " kc_cnpj_comp, kc_telefone_comp, kc_email_comp) VALUES (?,?,?,?,?)";

        template.update(insertEmpresaValues,companyData.getKc_nome_comp(), companyData.getKc_cep_comp(), companyData.getKc_cnpj_comp(),
                companyData.getKc_telefone_comp(),companyData.getKc_email_comp());

    }

}

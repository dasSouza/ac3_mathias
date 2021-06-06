package DAO;

;

import log.GerandoLog;
import java.io.IOException;
import jdbc.Conexao;
import Empresa.CompanyData;
import org.springframework.jdbc.core.JdbcTemplate;



public class CompanyDAO {

    public void insertIntoCompany() throws IOException {
//        Conection conection = new Conection();
        Conexao con = new Conexao();
        CompanyData companyData = new CompanyData();
        JdbcTemplate template = new JdbcTemplate(con.getBanco());

        String insertEmpresaValues = "INSERT INTO tb_empresa(kc_nome_comp, kc_cep_comp,"
                + " kc_cnpj_comp, kc_telefone_comp, kc_email_comp) VALUES (?,?,?,?,?)";

        template.update(insertEmpresaValues, companyData.getKc_nome_comp(), companyData.getKc_cep_comp(), companyData.getKc_cnpj_comp(),
                companyData.getKc_telefone_comp(), companyData.getKc_email_comp());

        GerandoLog gerarLog = new GerandoLog();

        try {
            gerarLog.gravarLog("\n inserindo dados na empresa");

        } catch (IOException e) {
            gerarLog.gravarLog("\n erro ao tentar inserir dados na empresa");

        }

    }

}

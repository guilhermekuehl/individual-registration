package br.com.guilhermekellermann.individual_registration.modules.auditLog;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@Component
@WebFilter("/*")
public class AuditLogFilter implements Filter {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Captura informações da requisição
        String username = httpRequest.getRemoteUser(); // Ou qualquer identificador do usuário
        String endpoint = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();

        // Cria um objeto de log de auditoria
        AuditLogEntity auditLog = new AuditLogEntity();
        auditLog.setUsername(username);
        auditLog.setEndpoint(endpoint);
        auditLog.setMethod(method);

        // Salva o log no banco de dados
        auditLogRepository.save(auditLog);

        // Continua o processamento da requisição
        chain.doFilter(request, response);
    }
}
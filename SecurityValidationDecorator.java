import java.util.List;

public class SecurityValidationDecorator extends QueryExecutorDecorator {
    private static final List<String> PALAVRAS = List.of(
            "DROP", "DELETE", "TRUNCATE", "ALTER"
    );
    private static final List<String> PADROES = List.of(
            "' OR '1'='1", "--", ";"
    );

    public SecurityValidationDecorator(QueryExecutor wrapped) {
        super(wrapped);
    }

    @Override
    public void execute(String sql) {
        String maiusculo = sql.toUpperCase();

        for (String p : PALAVRAS) {
            if (maiusculo.contains(p)) {
                System.out.println("Query bloqueada: palavra perigosa detectada.");
                return;
            }
        }
        for (String p : PADROES) {
            if (maiusculo.contains(p)) {
                System.out.println("Query bloqueada: possível SQL Injection detectado.");
                return;
            }
        }
        super.execute(sql);
    }
}

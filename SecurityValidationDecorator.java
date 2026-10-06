import java.util.List;

public class SecurityValidationDecorator extends QueryExecutorDecorator {
    private static final List<String> PROIBIDOS = List.of(
            "DROP", "DELETE", "TRUNCATE", "ALTER", "' OR '1'='1", "--", ";"
    );

    public SecurityValidationDecorator(QueryExecutor wrapped) {
        super(wrapped);
    }

    @Override
    public void execute(String sql) {
        if (contemPerigo(sql)) {
            System.out.println("[SECURITY] Query bloqueada por validação de segurança.");
            return;
        }
        super.execute(sql);
    }

    private boolean contemPerigo(String sql) {
        String maiusculo = sql.toUpperCase();
        for (String termo : PROIBIDOS) {
            if (maiusculo.contains(termo)) {
                return true;
            }
        }
        return false;
    }
}
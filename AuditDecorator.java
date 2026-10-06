public class AuditDecorator extends QueryExecutorDecorator {
    private final String usuario;

    public AuditDecorator(QueryExecutor wrapped, String usuario) {
        super(wrapped);
        this.usuario = usuario;
    }

    @Override
    public void execute(String sql) {
        System.out.println("[AUDIT] Usuário responsável: " + usuario);
        super.execute(sql);
    }
}
public class LoggingDecorator extends QueryExecutorDecorator {
    public LoggingDecorator(QueryExecutor wrapped) {
        super(wrapped);
    }

    @Override
    public void execute(String sql) {
        System.out.println("[LOG] Tentando executar query...");
        super.execute(sql);
    }
}
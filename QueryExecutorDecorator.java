public abstract class QueryExecutorDecorator implements QueryExecutor {
    protected final QueryExecutor wrapped;

    public QueryExecutorDecorator(QueryExecutor wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void execute(String sql) {
        wrapped.execute(sql);
    }
}
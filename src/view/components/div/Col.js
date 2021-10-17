const Col = ({
    xl,
    lg,
    md,
    sm,
    df,
    children
}) => {
    const type = (query, value, sep=":") => {
        return `${value ? `${query ? `${query}${sep}` : ''}col-${value}` : ''}`;
    }
    return (
        <div className={`${type(null, df)} ${type("xl", xl)} ${type("lg", lg)} ${type("md", md)} ${type("sm", sm)}`}>
            {children}
        </div>
    );
};
export default Col;
const Col = ({
    xl,
    lg,
    md,
    sm,
    children
}) => {
    return (
        <div className={`${xl ? `grid-xl-${xl}` : ''} ${lg ? `grid-lg-${lg}` : ''} ${md ? `grid-md-${md}` : ''} ${sm ? `grid-sm-${sm}` : ''}`}>
            {children}
        </div>
    );
};
export default Col;
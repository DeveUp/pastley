const Container = ({
    className,
    children
}) => {
    return (
        <div className={`pastley-container ${className ? className : ''}`}>
            {children}
        </div>
    );
};
export default Container;
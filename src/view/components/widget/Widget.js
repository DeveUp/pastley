import { useState } from "react";

/**
 * Start
 */
const Widget = ({ 
    className, 
    children, 
    title 
}) => {
    const [collapsed, setCollapsed] = useState(false);

    const onCollapsedHandler = () => {
        setCollapsed(prevState => !prevState);
    }

    return (
        <div className={`tt-mobile-collapse ${className ? className : ''}`}>
            {title && <h4 className={`tt-collapse-title ${collapsed ? 'tt-open' : ''}`} onClick={onCollapsedHandler}>{title}</h4>}
            <div className="tt-collapse-content">
                {children}
            </div>
        </div>
    );
};

/**
 * Export
 */
export default Widget;
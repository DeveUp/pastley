/**
 * Component
 */
import Widgets from './elements/Widgets';

/**
 * Start
 */
const Footer= ({ 
    className, 
    jsonCompany, 
    isDark 
}) => {
    return (
        <footer className={className ? className : ''}>
            <Widgets json={jsonCompany} isDark={isDark}/>
        </footer>
    );
};

/**
 * Export
 */
export default Footer;
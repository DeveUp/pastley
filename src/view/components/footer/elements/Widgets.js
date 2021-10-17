import Container from '../../div/Container';
import Col from '../../div/Col';

/**
 * Start
 */
const Widgets = ({ 
    className, 
    isDark 
}) => {
    return (
        <Container className={`${className ? className : ''} grid`}>
            <Col md={6} lg={4} xl={3}>
            </Col>
            <Col md={6} lg={4} xl={3}>
            </Col>
            <Col md={6} lg={4} xl={3}>
            </Col>
            <Col md={6} lg={4} xl={3}>
            </Col>
        </Container>
    );
};

/**
 * Export
 */
export default Widgets;


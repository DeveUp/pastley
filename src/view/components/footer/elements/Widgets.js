import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

/**
 * Component
 */
import Container from '../../div/Container';
import Col from '../../div/Col';
import Widget from '../../widget/Widget';

/**
 * Service
 */
import CategoryService from '../../user/category/service/CategoryService';
import CompanyService from '../../user/company/service/CompanyService';

/**
 * Start
 */
const Widgets = ({
    className,
    isDark,
    company
}) => {

    /**
     * State
     */
    const [categories, setCategories] = useState(null);
    const [companyAccount, setCompanyAccount] = useState(null);

    /**
     * Init Service
     */
    const serviceCategory = new CategoryService();
    const serviceCompany = new CompanyService();

    /**
     * Defect
     */
    useEffect(() => {
        serviceCategory.getCategoryActive().then(response => setCategories(response));
        serviceCompany.getCompanyAccount().then(response => setCompanyAccount(response));
    }, []);

    /**
     * Content
     */
    return (
        <Container className={`${className ? className : ''} grid`}>
            <Col xl={3} lg={4} md={6} df={12}>
                <Widget title="Categorias">
                    <ul>
                        {
                            (categories != null) ?
                                categories.map(category => (
                                    <li key={category.id}>
                                        <Link to={`/product/category/${category.id}`}>{category.name.toUpperCase()}</Link>
                                    </li>
                                ))
                                : 'No se han cargado las categorias de los productos.'
                        }
                    </ul>
                </Widget>
            </Col>
            <Col xl={3} lg={4} md={6} df={12}>
                <Widget title="Accesos">
                    {
                        (companyAccount != null) ?
                            companyAccount.map(item => (
                                <li key={item.id}>
                                    <Link to={item.link}>{item.name}</Link>
                                </li>
                            ))
                        : 'No se han cargado los accesos de la app.'
                    }
                </Widget>
            </Col>
            <Col xl={3} lg={4} md={12} df={12}>
                <Widget title="Conocenos">
                    {
                        (company != null) ? 
                            <p>{company.description}</p>
                        : 'No se ha cargado la descripción de la empresa.'
                    }
                </Widget>
            </Col>
            <Col xl={3} lg={12} md={12} df={12}>
                <Widget title="Contactanos">

                </Widget>
            </Col>
        </Container>
    );
};

/**
 * Export
 */
export default Widgets;


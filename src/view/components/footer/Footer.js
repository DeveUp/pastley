import React, { useState, useEffect } from 'react';

/**
 * Component
 */
import Widgets from './elements/Widgets';

/**
 * Service
 */
import CompanyService from '../user/company/service/CompanyService';

/**
 * Start
 */
const Footer = ({
    className,
    isDark
}) => {

    /**
     * State
     */
    const [company, setCompany] = useState(null);

    /**
     * Init Service
     */
    const serviceCompany = new CompanyService();

    /**
     * Defect
     */
    useEffect(() => {
        serviceCompany.getCompany().then(response => setCompany(response));
    }, []);

    /**
     * Content
     */
    return (
        <footer className={className ? className : ''}>
            <Widgets company={company} isDark={isDark} />
        </footer>
    );
};

/**
 * Export
 */
export default Footer;
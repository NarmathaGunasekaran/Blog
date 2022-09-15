import React from 'react'
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

const Footers = () => {
    return (
        <div> <Container fluid className="bg-dark text-light p-3 mt-2" fixed="bottom">
            <Row>
                <Col> Copyright @ Narmatha</Col>
            </Row>
        </Container></div>
    )
}

export default Footers
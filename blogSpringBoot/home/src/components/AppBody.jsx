import React from 'react'
import Container from "react-bootstrap/Container";

const AppBody = ({ children }) => {
  return (
    <Container fluid className="bg-dark bg-opacity-10 p-0 pb-3">
      {children}
    </Container>
  );
};

export default AppBody
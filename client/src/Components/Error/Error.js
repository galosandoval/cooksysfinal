const Error = (props) => {
  return (
    <section className="user-error">
      <span className="error">{props.children.message}</span>
    </section>
  );
};

export default Error;

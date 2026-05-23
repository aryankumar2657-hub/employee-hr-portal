import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { createEmployee, getEmployee, updateEmployee } from '../api.js';

const emptyEmployee = {
  firstname: '', lastname: '', email: '', department: '', designation: '', salary: '', joiningDate: '', phone: ''
};

export default function EmployeeForm() {
  const [employee, setEmployee] = useState(emptyEmployee);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) getEmployee(id).then(res => setEmployee(res.data));
  }, [id]);

  const handleChange = (e) => setEmployee({ ...employee, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (id) await updateEmployee(id, employee);
    else await createEmployee(employee);
    navigate('/');
  };

  return (
    <main className="container narrow">
      <section className="panel">
        <h2>{id ? 'Update Employee' : 'Add New Employee'}</h2>
        <form className="form-grid" onSubmit={handleSubmit}>
          <input name="firstname" value={employee.firstname} onChange={handleChange} placeholder="First name" required />
          <input name="lastname" value={employee.lastname} onChange={handleChange} placeholder="Last name" required />
          <input name="email" type="email" value={employee.email} onChange={handleChange} placeholder="Email address" required />
          <input name="phone" value={employee.phone} onChange={handleChange} placeholder="Phone number" />
          <input name="department" value={employee.department} onChange={handleChange} placeholder="Department" />
          <input name="designation" value={employee.designation} onChange={handleChange} placeholder="Designation" />
          <input name="salary" type="number" value={employee.salary} onChange={handleChange} placeholder="Monthly salary" />
          <input name="joiningDate" type="date" value={employee.joiningDate} onChange={handleChange} />
          <button className="submit-btn" type="submit">{id ? 'Save Changes' : 'Create Employee'}</button>
        </form>
      </section>
    </main>
  );
}

package com.example.mototracker_2.Sql.Repo;

import com.example.mototracker_2.Sql.Doa.PersonDoa;
import com.example.mototracker_2.Sql.helper.Saveable;
import com.example.mototracker_2.models.Person;



import java.util.List;

public class PersonRepo {
    private PersonDoa personDoa;

    public PersonRepo(PersonDoa personDoa) {
        this.personDoa = personDoa;
    }

    public List<Person> getPersons() {
        return personDoa.getAllRecords();
    }

    public boolean addPerson(Person person) {

        return personDoa.addRecord(person);
    }

    public void updatePerson(Person person) {
        personDoa.updateRecord(person);
    }

    public void deletePerson(Person person) {
        personDoa.deleteRecord(person);
    }

    public Person getPerson(String email, String password) {return personDoa.getRecord(email,password);}

    public boolean isPersonEmailExist(String email){return personDoa.propExist(email);}

}

student = {
    "Fornavn": "Titas",
    "Etternavn": "Palijanskas",
    "Favorittfag": "Programmering 1"
}

print(f"{student["Fornavn"]} {student["Etternavn"]}")

student["Favorittfag"] = "ITF10219 Programmering 1"
student.update({"age" : 19})

print(student)
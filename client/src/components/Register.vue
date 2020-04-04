<template>
<v-content>
  <v-container>
    <v-layout text-center wrap>
      
      <v-flex mb-4>
        <h1 class="display-2 font-weight-bold mb-3">
          ระบบลงทะเบียนเรียน
        </h1>
        
        <!-- semester -->
        <v-form v-model="validsec" ref="form">
              <v-row justify="center">
              <v-col cols="auto">
                <v-select
                  label="ภาคการศึกษา"
                  outlined
                  v-model="register.semesterId"
                  :items="semesters"
                  item-text="sem"
                  item-value="id"
              hide-selected
                  :rules="[(v) => !!v || '*กรุณาเลือกภาคการศึกษา']"
                  required
                ></v-select>
              </v-col>
            </v-row>

<!-- student -->
<v-row justify="center">
              <v-col cols="auto">
                <v-select
                  label="รหัสนักศึกษา"
                  outlined
                  v-model="register.studentId"
                  :items="students"
                  item-text="student_num"
                  item-value="id"
              hide-selected
                  :rules="[(v) => !!v || '*กรุณาเลือกรหัสนักศึกษา']"
                  required
                ></v-select>
              </v-col>
            </v-row>


<!-- subject -->
<v-row justify="center">
            <v-col cols="auto">
              <v-autocomplete
              v-model="register.subjectId"
              :items="subjects"
              item-text="sub_num"
              item-value="id"
              label="รายวิชา"
              placeholder="กรุณากรอกรหัสวิชา"
              hide-selected
              :rules="[(v) => !!v || 'กรุณากรอกรหัสวิชาที่ต้องการลงทะเบียนเรียน']"
              ></v-autocomplete>
            </v-col>
            
            <v-col cols='auto'> 
            <v-btn @click="getSections" :class="{ red: !validsec, green: validsec }">ค้นหา</v-btn>
            </v-col>
</v-row>
            <!-- section -->
            <div v-if="getSectionCheck">
        <v-row justify="center">
              <v-form v-model="validsave" ref="form">
                <v-col cols="auto">
        <p v-if="getSectionCheck != ''">{{this.register.subnum}} {{subjectName}}</p>
                <v-select
                label="กลุ่มเรียน"
                outlined
                v-model="register.sectionId"
                :items="sections"
                item-text="sec"
                item-value="id"
              hide-selected
                ></v-select>
                </v-col>
        </v-form>
        </v-row>
            </div>
        </v-form>

<!-- submit -->
<v-row justify="center">
              <v-col cols="auto">
                <v-btn @click="saveRegister" :class="{ red: !validsave, green: validsave }">ยืนยันการลงทะเบียน</v-btn>
              </v-col>
            </v-row>
      </v-flex>
    </v-layout>
  </v-container>
</v-content>
</template>

<script>

import http from "../http-common";

export default {
  name: "register",
  data() {
    return {
      register: {
        studentId: "",
        semesterId: "",
        sectionId: "",
        subjectId:"",
        subnum:null,
        credit:null
      },
      semesters:[],
      students:[],
      subjects:[],
      sections:[],
      s:[],
      validsec: false,
      validsave: false,
      getSectionCheck: false,
      saveCheck: false,
      studentName: "",
      subjectName: "",
      subjectNum:""
    };
  },
  methods: {
    /* eslint-disable no-console */
    getSemesters() {
      http
        .get("/semester")
        .then(response => {
          this.semesters = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getStudents() {
      http
        .get("/student")
        .then(response => {
          this.students = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getSubjects() {
      http
        .get("/subject")
        .then(response => {
          this.subjects = response.data;
          console.log(response.data);
          //this.getSections();
        })
        .catch(e => {
          console.log(e);
        });
    },
       getSubnum() {
      http
        .get("/subject/" + this.register.subjectId)
        .then(response => {
          //this.subjects = response.data;
          console.log(response.data);
          this.s = response.data;
          this.register.subnum = response.data.sub_num;
          this.register.credit = response.data.credit;
          this.subjectName = response.data.sub_name;
          if(response.data!=null)
          this.saveCheck = response.status;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getSections() {
      http
        .get("/section/" + this.register.subjectId)
        .then(response => {
          if(response.data!=null)
          this.sections = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
        this.getSubnum();
    },
    
    saveRegister() {
      http
        .post(
          "/register/" +
            this.register.studentId
            + "/"  +
            this.register.semesterId
            + "/"  +
            this.register.sectionId
            + "/" +
            this.register.subnum
            + "/" +
            this.register.credit,
          this.register
        )
        .then(response => {
          console.log(response);
          this.$router.push("/viewreg");
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    refreshList() {
    this.getSemesters();
    this.getStudents();
    this.getSubjects();
    this.getSections();
    this.getSubnum();
    
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getSemesters();
    this.getStudents();
    this.getSubjects();
    this.getSections();
    this.getSubnum();

  }
}
</script>


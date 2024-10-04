package services;

import data.Database;
import entities.Project;
import entities.User;
import entities.Work;
import utils.Constant;
import utils.Untils;
import views.LoginMenu;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WorkService implements IAddDeleteUpdate {
    // thêm degssi puatusu
    ProjectService projectService = ProjectService.getInstance();
    private static WorkService workService;
    public static synchronized WorkService getInstance(){
        if (workService == null){
            workService = new WorkService();
        }
        return workService;
    }
    public Work inputWorks(Scanner sc){
        System.out.println("Tên công việc");
        String workName = sc.nextLine();
        System.out.println("Mô tả công việc");
        String workDescription = sc.nextLine();
        System.out.println("Nhập thời gian tạo công việc");
        LocalDate addDate = Untils.convertStringToDate(sc, "dd/MM/yyyy");
        System.out.println("Nhập thời gian bắt đầu làm công việc");
        LocalDate startDate = Untils.convertStringToDate(sc,"dd/MM/yyyy");
        System.out.println("Nhập thời gian kết thúc công việc");
        LocalDate endDate = Untils.convertStringToDate(sc,"dd/MM/yyyy");
        System.out.println("Nhập thái thái");
        String status = sc.nextLine();
        // Tạo đối tượng Work và trả về
        return new Work(workName, workDescription, addDate, startDate, endDate, status);
    }

    // Phương thức để thêm nhiệm vụ vào danh sách của dự án
    public void addWorkToProject(Scanner sc) {

        // Yêu cầu người dùng nhập tên dự án
        System.out.println("Nhập id dự án cần thêm công việc:");
        int id = Untils.inputInteger(sc);

        if (projectService.findById(id) != null){
            // Kiểm tra xem dự án đã tồn tại trong HashMap chưa
            ArrayList<Work> works = Database.projectWorks.getOrDefault(id, new ArrayList<>());

            // Nhập thông tin nhiệm vụ
            Work work = inputWorks(sc);

            // Thêm nhiệm vụ vào danh sách
            works.add(work);

            // Cập nhật lại HashMap
            Database.projectWorks.put(id, works);

            System.out.println("công việc đã được thêm vào dự án: " + id);
        }else {
            System.out.println("không tồn tại dự án với id " + id);
        }
    }





    // TÌm kiếm công việc danh sách công việc hiện có
    @Override
    public void findBy(Scanner sc) {
        System.out.println("Nhập id dự án muốn xem");
        int projectId = Untils.inputInteger(sc);
        ArrayList<Work> works = Database.projectWorks.get(projectId);
        System.out.println("Danh sách nhiệm vụ của dự án ID: " + projectId);
        for (int i = 0; i < works.size(); i++) {
            System.out.println((i + 1) + ". " + works.get(i).getName());
        }
    }

    // xóa công việc của từng dự án theo projectId
    @Override
    public void remove(Scanner sc) {
        System.out.println("Nhập id dự án cần xóa công việc");
        int projectId= Untils.inputInteger(sc);
        ArrayList<Work> works = Database.projectWorks.get(projectId);
        if (works == null || works.isEmpty()) {
            System.out.println("Dự án này chưa có công việc nào.");
            return;
        }
        // Hiển thị danh sách công việc hiện có
        System.out.println("Danh sách công việc của dự án ID: " + projectId);
        for (int i = 0; i < works.size(); i++) {
            System.out.println((i + 1) + ". " + works.get(i).getName());
        }
        // Yêu cầu người dùng nhập số thứ tự của nhiệm vụ muốn xóa
        System.out.println("Nhập số thứ tự công việc muốn xóa:");
        int workIndex = Untils.inputInteger(sc) - 1;

        // Kiểm tra chỉ số hợp lệ
        if (workIndex < 0 || workIndex >= works.size()) {
            System.out.println("Chỉ số không hợp lệ.");
        } else {
            // Xóa nhiệm vụ
            Work removedWork = works.remove(workIndex);
            System.out.println("Đã xóa công việc: " + removedWork.getName());
            Database.projectWorks.put(projectId, works);
        }
    }

    // sữa công việc
    @Override
    public void edit(Scanner sc) {
        System.out.println("Nhập id dự án cần xóa công việc");
        int projectId= Untils.inputInteger(sc);
        ArrayList<Work> works = Database.projectWorks.get(projectId);
        if (works == null || works.isEmpty()) {
            System.out.println("Dự án này chưa có công việc nào.");
            return;
        }
        // Hiển thị danh sách công việc hiện có
        System.out.println("Danh sách công việc của dự án ID: " + projectId);
        for (int i = 0; i < works.size(); i++) {
            System.out.println((i + 1) + ". " + works.get(i).getName());
        }
        // Yêu cầu người dùng nhập số thứ tự của nhiệm vụ muốn sữa
        System.out.println("Nhập số thứ tự công việc muốn sữa:");
        int workIndex = Untils.inputInteger(sc) - 1;

        Work workUpdate = works.get(workIndex);
        // Kiểm tra chỉ số hợp lệ
        if (workIndex < 0 || workIndex >= works.size()) {
            System.out.println("Chỉ số không hợp lệ.");
        } else {
            // Sữa nhiệm vụ
            System.out.println("Hãy sữa thông tin bạn muốn chỉnh sữa");
            System.out.println("Tên công việc");
            String workName = sc.nextLine();
            System.out.println("Mô tả công việc");
            String workDescription = sc.nextLine();
            System.out.println("Nhập thời gian tạo công việc");
            LocalDate addDate = Untils.convertStringToDate(sc, "dd/MM/yyyy");
            System.out.println("Nhập thời gian bắt đầu làm công việc");
            LocalDate startDate = Untils.convertStringToDate(sc,"dd/MM/yyyy");
            System.out.println("Nhập thời gian kết thúc công việc");
            LocalDate endDate = Untils.convertStringToDate(sc,"dd/MM/yyyy");
            System.out.println("Nhập thái thái");
            String status = sc.nextLine();
            workUpdate.setName(workName);
            workUpdate.setWorkDescription(workDescription);
            workUpdate.setAddDate(addDate);
            workUpdate.setStartDate(startDate);
            workUpdate.setEndDate(endDate);
            workUpdate.setStatus(status);
            System.out.println("Công việc được chỉnh Sữa thành công");
        }
    }

    // hiễn thị chi tiết công việc
    @Override
    public void display(Scanner sc) {
        System.out.println("Nhập ID dự án:");
        int projectId = Untils.inputInteger(sc);

        // Kiểm tra xem dự án có tồn tại trong HashMap không
        if (Database.projectWorks.containsKey(projectId)) {
            ArrayList<Work> works = Database.projectWorks.get(projectId);

            // Nếu dự án có công việc, hiển thị danh sách công việc
            if (!works.isEmpty()) {
                System.out.println("Danh sách công việc trong dự án " + projectId + ":");
                for (int i = 0; i < works.size(); i++) {
                    System.out.println((i + 1) + ". " + works.get(i).getName());
                }

                // Nhập lựa chọn công việc
                System.out.println("Nhập số thứ tự của công việc để xem chi tiết:");
                int workChoice = Untils.inputInteger(sc);

                // Kiểm tra tính hợp lệ của lựa chọn
                if (workChoice > 0 && workChoice <= works.size()) {
                    Work selectedWork = works.get(workChoice - 1);

                    // Hiển thị chi tiết công việc
                    System.out.println("------------------------------------------------");
                    System.out.println("Chi tiết công việc:");
                    System.out.println("ID: "              + selectedWork.getId());
                    System.out.println("Tên công việc: "   + selectedWork.getName());
                    System.out.println("Mô tả công việc: " + selectedWork.getWorkDescription());
                    System.out.println("Ngày tạo: "        + selectedWork.getAddDate());
                    System.out.println("Ngày bắt đầu: "    + selectedWork.getStartDate());
                    System.out.println("Ngày kết thúc: "   + selectedWork.getEndDate());
                    System.out.println("Trạng thái: "      + selectedWork.getStatus());
                    System.out.println("-----------------------------------------------");
                } else {
                    System.out.println("công việc bạn nhập không tồn tại");
                }
            } else {
                System.out.println("Không có công việc nào trong dự án này.");
            }
        } else {
            System.out.println("Dự án với ID " + projectId + " không tồn tại.");
        }
    }


    // phân công công việc chức năng 3
    public void assignByUserId(Scanner sc, User user, ArrayList<User> users) {
        System.out.println("Nhập ID dự án muốn phân công:");
        int projectId = Untils.inputInteger(sc);

        if (Database.projectWorks.containsKey(projectId)) {
            ArrayList<Work> works = Database.projectWorks.get(projectId);

            if (works != null && !works.isEmpty()) {
                System.out.println("Danh sách công việc của dự án ID: " + projectId);
                for (int i = 0; i < works.size(); i++) {
                    System.out.println((i + 1) + ". " + works.get(i).getName());
                }

                // Nhập số thứ tự công việc để gán
                System.out.println("Nhập số thứ tự công việc bạn muốn bàn giao:");
                int workIndex = Untils.inputInteger(sc) - 1; // Giảm 1 để phù hợp với chỉ số mảng

                // Kiểm tra workIndex hợp lệ
                if (workIndex >= 0 && workIndex < works.size()) {
                    Work selectedWork = works.get(workIndex);

                    // Nhập ID của nhân viên để gán công việc
                    System.out.println("Nhập ID nhân viên để gán công việc:");
                    int employeeId = Untils.inputInteger(sc);

                    // Kiểm tra xem ID nhân viên có tồn tại không
                    boolean employeeFound = false;
                    for (User u : users) {
                        if (u.getId() == employeeId) {
                            employeeFound = true;
                            selectedWork.setAssignee(employeeId); // Gán ID của nhân viên cho công việc
                            selectedWork.setStatus("Đã bàn giao cho nhân viên ID = " + employeeId);
                            selectedWork.setProjectCreator("Xếp KAISHA");
                            System.out.println("Người giao: " + selectedWork.getProjectCreator() +
                                    ". Công việc \"" + selectedWork.getName() + "\" đã được gán cho nhân viên ID: " + employeeId);
                            break;
                        }
                    }

                    if (!employeeFound) {
                        System.out.println("Không tìm thấy nhân viên với ID: " + employeeId);
                    }

                } else {
                    System.out.println("Công việc bạn nhập không tồn tại. Vui lòng chọn số thứ tự hợp lệ.");
                }

            } else {
                System.out.println("Không có công việc trong dự án này.");
            }

        } else {
            System.out.println("Không có dự án với ID: " + projectId);
        }
    }

   /* public void assignByUserId(Scanner sc, User user, ArrayList<User> users) {
        System.out.println("Nhập ID dự án muốn phân công:");
        int projectId = Untils.inputInteger(sc);

        if (Database.projectWorks.containsKey(projectId)) {
            ArrayList<Work> works = Database.projectWorks.get(projectId);

            if (works != null && !works.isEmpty()) {
                System.out.println("Danh sách công việc của dự án ID: " + projectId);
                for (int i = 0; i < works.size(); i++) {
                    System.out.println((i + 1) + ". " + works.get(i).getName());
                }

                // Nhập số thứ tự công việc để gán
                System.out.println("Nhập số thứ tự công việc bạn muốn bàn giao:");
                int workIndex = Untils.inputInteger(sc) - 1; // Giảm 1 để phù hợp với chỉ số mảng

                // Kiểm tra workIndex hợp lệ
                if (workIndex >= 0 && workIndex < works.size()) {
                    Work selectedWork = works.get(workIndex);

                    // Hiển thị danh sách trưởng phòng (ROLE_MANAGE)
                    System.out.println("Danh sách trưởng phòng:");
                    for (User u : users) {
                        if (u.getRole().equals(Constant.ROLE_MANAGE)) {
                            System.out.println("ID: " + u.getId() + " - Tên: " + u.getUsername());
                        }
                    }

                    // Nhập ID của trưởng phòng để gán công việc
                    System.out.println("Nhập ID trưởng phòng để gán công việc:");
                    int managerId = Untils.inputInteger(sc);

                    // Kiểm tra xem ID có thuộc về trưởng phòng không
                    boolean managerFound = false;
                    for (User u : users) {
                        if (u.getId() == managerId && u.getRole().equals(Constant.ROLE_MANAGE)) {
                            managerFound = true;
                            selectedWork.setAssignee(managerId); // Gán ID của trưởng phòng cho công việc
                            selectedWork.setStatus("Đã bàn giao cho trưởng phòng ID = " + managerId);
                            selectedWork.setProjectCreator("Xếp KAISHA");
                            System.out.println("Người giao: " + selectedWork.getProjectCreator() +
                                    ". Công việc \"" + selectedWork.getName() + "\" đã được gán cho trưởng phòng ID: " + managerId);
                            break;
                        }
                    }

                    if (!managerFound) {
                        System.out.println("Không tìm thấy trưởng phòng với ID: " + managerId);
                    }

                } else {
                    System.out.println("Công việc bạn nhập không tồn tại. Vui lòng chọn số thứ tự hợp lệ.");
                }

            } else {
                System.out.println("Không có công việc trong dự án này.");
            }

        } else {
            System.out.println("Không có dự án với ID: " + projectId);
        }
    }
*/

    public void viewAssignedWorksByUserId(Scanner sc, User user) {
        System.out.println("Danh sách công việc đã giao cho bạn:");

        boolean hasAssignedWorks = false;
        int userId = user.getId(); // Lấy ID của nhân viên

        // Duyệt qua tất cả công việc trong Database
        for (ArrayList<Work> works : Database.projectWorks.values()) {
            for (Work work : works) {
                if (work.getAssignee() == userId) { // Kiểm tra xem công việc có được gán cho nhân viên không
                    System.out.println("Công việc: " + work.getName() +
                            ", Trạng thái: " + work.getStatus() +
                            ", Người giao: " + work.getProjectCreator());
                    hasAssignedWorks = true;
                }
            }
        }

        if (!hasAssignedWorks) {
            System.out.println("Bạn chưa có công việc nào được giao.");
        }
    }









   /* public void assignByUserId(Scanner sc,User user, ArrayList<User> users) {
        System.out.println("Nhập ID dự án muốn phân công:");
        int projectId = Untils.inputInteger(sc);

        if (Database.projectWorks.containsKey(projectId)) {
            ArrayList<Work> works = Database.projectWorks.get(projectId);

            if (works != null && !works.isEmpty()) {
                System.out.println("Danh sách công việc của dự án ID: " + projectId);
                for (int i = 0; i < works.size(); i++) {
                    System.out.println((i + 1) + ". " + works.get(i).getName());
                }
                // Nhập số thứ tự công việc để gán
                    System.out.println("Nhập số thứ tự công việc bạn muốn bàn giao");
                     int workIndex = Untils.inputInteger(sc) - 1; // Giảm 1 để phù hợp với chỉ số mảng
                    // Kiểm tra workIndex hợp lệ
                    if (workIndex >= 0 && workIndex < works.size()) {
                        Work selectedWork = works.get(workIndex);
                        UserServices userServices = new UserServices();
                        userServices.displayRegisters(users);
                        // Nhập ID người dùng để gán
                        System.out.println("Nhập ID người dùng để gán công việc:");
                        int userId = Untils.inputInteger(sc);
                        if (userId == 1) {
                            System.out.println("t là sếp ");
                        } else if (userId > 0 && userId <= users.size()) {
                            selectedWork.setAssignee(userId);
                            selectedWork.setStatus("đã bàn giao cho nhân viên có id = " + userId);
                            selectedWork.setProjectCreator("Xếp KAISHA");
                            System.out.println("Người giao" + selectedWork.getProjectCreator() + "Công việc \"" + selectedWork.getName() + "\" đã được gán cho người dùng ID: " + userId);
                        } else {
                            System.out.println("không tim thấy thành vie với id " + userId);
                        }
                    } else {
                        System.out.println("Công việc bạn nhập không tồn tại. Vui lòng chọn số thứ tự hợp lệ.");
                    }
                }else {
                System.out.println("không có công việc");
            }
            } else {
                System.out.println("Không có dự án");
            }
        }*/

















    // lịch sử phân công
    public void viewAssignmentHistory(int projectId) {
        // Lấy danh sách công việc từ dự án theo projectId
        ArrayList<Work> works = Database.projectWorks.get(projectId);

        if (works == null || works.isEmpty()) {
            System.out.println("Dự án không có công việc nào hoặc không tồn tại.");
            return;
        }

        System.out.println("Lịch sử phân công công việc của dự án ID: " + projectId);

        // Duyệt qua danh sách công việc để hiển thị lịch sử phân công
        for (int i = 0; i < works.size(); i++) {
            Work work = works.get(i);
            System.out.println((i + 1) + ". Công việc: " + work.getName());

            if (work.getAssignee() != -1) {
                System.out.println("   -> Đã bàn giao cho nhân viên ID: " + work.getAssignee());
                System.out.println("   -> Trạng thái: " + work.getStatus());
            } else {
                System.out.println("   -> Công việc chưa được bàn giao.");
            }
        }
    }


    // hiễn thị công việc lại trạng thái

/*    public void displayWorksStatus(ArrayList<Work> works) {
        if (works == null || works.isEmpty()) {
            System.out.println("Không có công việc nào để hiển thị.");
            return;
        }

        System.out.println("Danh sách công việc và trạng thái:");
        for (int i = 0; i < works.size(); i++) {
            Work work = works.get(i);
            System.out.println((i + 1) + ". " + work.getWorkName() + " - Trạng thái: " + work.getStatus());
        }
    }*/



    // danh sách các công việc thuộc projectId
    public void findProjectsById(int projectId){
        ArrayList<Work> works = new ArrayList<>();
        for (Work work: Database.works) {
            if (work.getProjectId() == projectId){
                works.add(work);
            }
        }
        System.out.println(works);
    }


    public Project findProjectByProjectNameAndProjectId(int projectId, String projectName) {
        for (Project project : Database.projects) {
            // So sánh ID và tên dự án không phân biệt chữ hoa, chữ thường
            if (project.getId() == projectId && project.getProjectName().equalsIgnoreCase(projectName)) {
                return project;
            }
        }
        return null;
    }

   /* public void displayWorksById(Scanner sc){
        System.out.println("Nhập id dự án");
        int projectId = Untils.inputInteger(sc);
        System.out.println("Nhập id Công việc của dự án");
        int workId = Untils.inputInteger(sc);
        Work work = findWorksByWordId(workId);
        work.setProjectId(projectId);
        diplayWorkInfo(work);
    }*/


    // chức nắng số 5 : quản lý thành viên
    public void appointManagerById(Scanner sc, ArrayList<User> users) {
        System.out.println("Nhập ID của nhân viên muốn bổ nhiệm làm trưởng phòng: ");
        int userId = Untils.inputInteger(sc);

        // Tìm kiếm nhân viên theo userId
        User staff = findUserById(userId, users);
        if (staff != null && staff.getRole().equals(Constant.ROLE_STAFF)) {
            // Thay đổi vai trò thành trưởng phòng
            staff.setRole(Constant.ROLE_MANAGE);
            System.out.println("Đã bổ nhiệm nhân viên có ID " + userId + " làm trưởng phòng.");
        } else {
            System.out.println("Không tìm thấy nhân viên hoặc nhân viên này không phải là nhân viên.");
        }
    }

    public void demoteManagerById(Scanner sc, ArrayList<User> users) {
        System.out.println("Nhập ID của trưởng phòng muốn giáng chức xuống nhân viên: ");
        int userId = Untils.inputInteger(sc);
        // Tìm kiếm trưởng phòng theo userId
        User manager = findUserById(userId, users);
        if (manager != null && manager.getRole().equals(Constant.ROLE_MANAGE)) {
            // Thay đổi vai trò thành nhân viên
            manager.setRole(Constant.ROLE_STAFF);
            System.out.println("Đã giáng chức trưởng phòng có ID " + userId + " xuống nhân viên.");
        } else {
            System.out.println("Không tìm thấy trưởng phòng hoặc người này không phải là trưởng phòng.");
        }
    }

    // Hàm hỗ trợ tìm kiếm người dùng theo ID
    public User findUserById(int userId, ArrayList<User> users) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    // hiễn thị tất cả nhân viên trưởng phòng
    public void displayStaffAndManagers(ArrayList<User> users) {
        System.out.println("--- Danh sách Nhân viên và Trưởng phòng ---");
        for (User user : users) {
            if (user.getRole().equals(Constant.ROLE_STAFF)) {
                System.out.println("Nhân viên: " + " ID :" + user.getId() + ", Tên:" +user.getUsername() + ", Email:" + user.getEmail() + ", Role: " + user.getRole());
            } else if (user.getRole().equals(Constant.ROLE_MANAGE)) {
                System.out.println("Trưởng phòng: " + " ID :" + user.getId() + ", Tên:" +user.getUsername() + ", Email:" + user.getEmail() + ", Role: " + user.getRole());
            }
        }
    }


  /*  public void viewAssignedWorks(Scanner sc, ArrayList<User> users) {
        System.out.println("Nhập ID của bạn để xem công việc ");
        int userId = Untils.inputInteger(sc);
        User user = findUserById(userId, users);
        if (user != null && user.getId() == userId){
            boolean hasWorks = false;

            System.out.println("Danh sách công việc được giao cho người dùng có ID: " + userId);

            // Lặp qua tất cả các danh sách công việc trong projectWorks
            for (ArrayList<Work> works : Database.projectWorks.values()) {
                for (Work work : works) {
                    // Kiểm tra xem công việc có phải do người dùng này hay không
                    if (work.getAssignee() == userId) {
                        hasWorks = true;
                        System.out.println("Công việc: " + work.getName() + ", Mô tả: " + work.getWorkDescription() +
                                 ", Người giao" + work.getProjectCreator());
                    }
                }
            }
            if (!hasWorks) {
                System.out.println("Không có công việc nào được giao cho người dùng với ID: " + userId);
            }
        }

    }*/


    public void findByAssignee(int assignee){
        // danh sách những công vịeec của 1 id
        List<Work> works = new ArrayList<>();
        for (Work work: Database.works){
            if(work.getAssignee() == assignee){
                works.add(work);
            }
        }
        System.out.println(works);
    }



}


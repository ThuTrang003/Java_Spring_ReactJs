import { Button, Pagination, Table } from "antd";
import { useState } from "react";
import LoadingIndicator from "../loading";
import ModalCreateNhanVien from "./modalCreateNhanVien/modaCreate";

const Home = () => {
    const [currentPage, setCurrentPage] = useState(0);
    const [totalPages, setToTalPages] = useState(0);
    const [isLoading, setIsLoading] = useState(false);
    const [isModalCreate, setIsModalCreate] = useState(false);

    const handleClickModalCreateNhanVien = () => {
        setIsModalCreate(true);
    };

    const handleCancel = () => {
        setIsModalCreate(false);
    };

    const columns = [
        {
          title: "STT",
          dataIndex: "stt",
          key: "stt",
        },
        {
          title: "Tên",
          dataIndex: "ten",
          key: "ten",
        },
        {
          title: "Địa chỉ",
          dataIndex: "diaChi",
          key: "diaChi",
        },
        {
          title: "Giới tính",
          dataIndex: "gioiTinh",
          key: "gioiTinh",
        },
        {
          title: "Mã",
          dataIndex: "ma",
          key: "ma",
        },
        {
          title: "Số điện thoại",
          dataIndex: "sdt",
          key: "sdt",
        },
        
    ];

    return (
        <div>
            {isLoading && <LoadingIndicator />}
            <h2>Quản lý nhân viên</h2>
            <Button
            // onClick={handleClickModalCreateNhanVien}
            >Add</Button>
            <Table
                // dataSource={listNhanVienRedux}
                pagination={false}
                rowKey="id"
                columns={columns}
            />
            <Pagination
                simple
                current={currentPage + 1}
                onChange={(value) => {
                    setCurrentPage(value - 1);
                }}
                total={totalPages * 10}
            />
            <ModalCreateNhanVien
                visible={isModalCreate}
                handleCancel={handleCancel}
            />
        </div>
    );
};
export default Home;
